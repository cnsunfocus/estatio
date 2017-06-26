package org.estatio.capex.dom.documents.categorisation.tasks;

import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.services.queryresultscache.QueryResultsCache;
import org.apache.isis.applib.value.Blob;

import org.incode.module.document.dom.impl.docs.Document;
import org.incode.module.document.dom.impl.docs.DocumentAbstract;

import org.estatio.capex.dom.documents.categorisation.IncomingDocumentCategorisationStateTransition;
import org.estatio.capex.dom.invoice.IncomingInvoice;
import org.estatio.capex.dom.documents.LookupAttachedPdfService;
import org.estatio.capex.dom.invoice.approval.IncomingInvoiceApprovalStateTransition;
import org.estatio.capex.dom.state.StateTransition;
import org.estatio.capex.dom.state.StateTransitionService;
import org.estatio.capex.dom.task.Task;

@DomainService(nature = NatureOfService.DOMAIN)
public class TaskIncomingDocumentPdfService {

    @Programmatic
    public Blob lookupPdfFor(final Task task) {
        return queryResultsCache.execute(
                () -> doLookupPdfFor(task),
                TaskIncomingDocumentPdfService.class,
                "lookupPdfFor", task);
    }

    private Blob doLookupPdfFor(final Task task) {
        StateTransition<?,?,?,?> stateTransition = stateTransitionService.findFor(task);
        if(stateTransition == null) {
            return null;
        }

        if(stateTransition instanceof IncomingDocumentCategorisationStateTransition) {
            IncomingDocumentCategorisationStateTransition idcst =
                    (IncomingDocumentCategorisationStateTransition) stateTransition;
            final Document document = idcst.getDocument();
            if(document == null) {
                return null;
            }
            if (!Objects.equals(document.getMimeType(), "application/pdf")) {
                return null;
            }
            return document.getBlob();
        }

        if(stateTransition instanceof IncomingInvoiceApprovalStateTransition) {
            final IncomingInvoiceApprovalStateTransition iiast =
                    (IncomingInvoiceApprovalStateTransition) stateTransition;
            final IncomingInvoice invoice = iiast.getInvoice();
            final Optional<Document> documentIfAny = lookupAttachedPdfService.lookupIncomingInvoicePdfFrom(invoice);
            return documentIfAny.map(DocumentAbstract::getBlob).orElse(null);
        }

        return null;
    }

    @Inject
    LookupAttachedPdfService lookupAttachedPdfService;

    @Inject
    StateTransitionService stateTransitionService;

    @Inject
    QueryResultsCache queryResultsCache;

}

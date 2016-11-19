package bg.softuni.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import bg.softuni.model.competition.Competition;
import bg.softuni.model.user.User;
import bg.softuni.service.CompetitionService;

@ManagedBean(name = "competitionAllDataBean")
@SessionScoped
public class CompetitionAllDataBean {

    @EJB
    private CompetitionService competitionService;

    @Inject
    private HttpServletRequest request;

    private Competition competition;

    private StreamedContent stagesPdf;
    private UploadedFile stagesFile;

    private StreamedContent squadsPdf;
    private UploadedFile squadsFile;

    private StreamedContent resultsPdf;
    private UploadedFile resultsFile;

    private int activeIndex = 0;

    @PostConstruct
    public void init() {
        competition = (Competition) request.getSession().getAttribute("CURRENT_COMPETITION");
    }

    public int getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }

    /* Stages */

    public UploadedFile getStagesFile() {
        return stagesFile;
    }

    public void setStagesFile(UploadedFile stagesFile) {
        this.stagesFile = stagesFile;
    }

    public void updateStagesFile(FileUploadEvent event) {
        setStagesFile(event.getFile());
        competition.setStages(event.getFile().getContents());
        competitionService.editCompetition(competition);
        setActiveIndex(1);
        FacesContext ctx = FacesContext.getCurrentInstance();
        String url = ctx.getExternalContext().encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx,
                "/page/generalInfo.xhtml?faces-redirect=true"));
        try {
            ctx.getExternalContext().redirect(url);
            setActiveIndex(0);
        } catch (IOException ioe) {
            throw new FacesException(ioe);
        }
    }

    public StreamedContent getStagesPdf() {
        updateStagesPdf();
        return stagesPdf;
    }

    public void setStagesPdf(StreamedContent stagesPdf) {
        this.stagesPdf = stagesPdf;
    }

    /* Squads */

    public UploadedFile getSquadsFile() {
        return squadsFile;
    }

    public void setSquadsFile(UploadedFile squadsFile) {
        this.squadsFile = squadsFile;
    }

    public void updateSquadsFile(FileUploadEvent event) {
        setSquadsFile(event.getFile());
        competition.setSquads(event.getFile().getContents());
        competitionService.editCompetition(competition);
        updateSquadsPdf();
        setActiveIndex(1);
        FacesContext ctx = FacesContext.getCurrentInstance();
        String url = ctx.getExternalContext().encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx,
                "/page/generalInfo.xhtml?faces-redirect=true"));
        try {
            ctx.getExternalContext().redirect(url);
            setActiveIndex(0);
        } catch (IOException ioe) {
            throw new FacesException(ioe);
        }
    }

    public StreamedContent getSquadsPdf() {
        updateSquadsPdf();
        return squadsPdf;
    }

    public void setSquadsPdf(StreamedContent squadsPdf) {
        this.squadsPdf = squadsPdf;
    }

    /* Results */

    public UploadedFile getResultsFile() {
        return resultsFile;
    }

    public void setResultsFile(UploadedFile resultsFile) {
        this.resultsFile = resultsFile;
    }

    public void updateResultsFile(FileUploadEvent event) {
        setResultsFile(event.getFile());
        competition.setResults(event.getFile().getContents());
        competitionService.editCompetition(competition);
        setActiveIndex(1);
        FacesContext ctx = FacesContext.getCurrentInstance();
        String url = ctx.getExternalContext().encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx,
                "/page/generalInfo.xhtml?faces-redirect=true"));
        try {
            ctx.getExternalContext().redirect(url);
            setActiveIndex(0);
        } catch (IOException ioe) {
            throw new FacesException(ioe);
        }
    }

    public StreamedContent getResultsPdf() {
        updateResultsPdf();
        return resultsPdf;
    }

    public void setResultsPdf(StreamedContent resultsPdf) {
        this.resultsPdf = resultsPdf;
    }

    private void updateStagesPdf() {
        if (competition.getStages() != null) {
            InputStream stream = new ByteArrayInputStream(competition.getStages());
            StreamedContent streamedContent = new DefaultStreamedContent(stream, "application/pdf");
            setStagesPdf(streamedContent);

        } else {
            setStagesPdf(new DefaultStreamedContent());
        }
    }

    private void updateSquadsPdf() {
        if (competition.getSquads() != null) {
            InputStream stream = new ByteArrayInputStream(competition.getSquads());
            StreamedContent streamedContent = new DefaultStreamedContent(stream, "application/pdf");
            setSquadsPdf(streamedContent);
        } else {
            setSquadsPdf(new DefaultStreamedContent());
        }
    }

    private void updateResultsPdf() {
        if (competition.getResults() != null) {
            InputStream stream = new ByteArrayInputStream(competition.getResults());
            StreamedContent streamedContent = new DefaultStreamedContent(stream, "application/pdf");
            setResultsPdf(streamedContent);
        } else {
            setResultsPdf(new DefaultStreamedContent());
        }
    }

    public List<User> getCompetitors() {
        return competitionService.getCompetitors(competition);
    }

    // ******************
    public CompetitionService getCompetitionService() {
        return competitionService;
    }

    public void setCompetitionService(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {

        this.competition = competition;
    }
}

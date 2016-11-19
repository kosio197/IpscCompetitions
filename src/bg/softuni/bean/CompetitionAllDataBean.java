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

    private int activeIndex = 0;

    public int getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }

    @PostConstruct
    public void init() {
        competition = (Competition) request.getSession().getAttribute("CURRENT_COMPETITION");
        updateStagesPdf();
    }

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
        updateStagesPdf();
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
        return stagesPdf;
    }

    public void setStagesPdf(StreamedContent stagesPdf) {
        this.stagesPdf = stagesPdf;
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

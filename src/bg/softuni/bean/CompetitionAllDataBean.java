package bg.softuni.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import bg.softuni.model.competition.Competition;
import bg.softuni.model.competition.Squad;
import bg.softuni.model.competition.Stage;
import bg.softuni.model.user.User;
import bg.softuni.service.CompetitionService;

@ManagedBean(name = "competitionAllDataBean")
@ViewScoped
public class CompetitionAllDataBean {

    @EJB
    private CompetitionService competitionService;
    @Inject
    private HttpServletRequest request;

    private Competition competition;
    private StreamedContent squad;
    private StreamedContent stage;

    @PostConstruct
    public void init() {
        this.competition = (Competition) request.getSession().getAttribute("CURRENT_COMPETITION");

        Path path = Paths.get("/home/kosio/work/workspace/EE/IpscCompetitionsWeb/WebContent/images/stages.pdf");
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream ipps = new ByteArrayInputStream(data);
        this.stage = new DefaultStreamedContent(ipps, "application/pdf");
    }

    public void addStage(FileUploadEvent event) {
        String fileName = event.getFile().getFileName();
        if (fileName.startsWith("stages")) {
            competition.setStages(event.getFile().getContents());
            competitionService.editCompetition(competition);
        } else if (fileName.startsWith("squads")) {
            competition.setSquads(event.getFile().getContents());
            competitionService.editCompetition(competition);
        }

    }

    public StreamedContent getStage() {
        if (competition.getStages() != null) {
            InputStream stream = new ByteArrayInputStream(competition.getStages());
            StreamedContent streamedContent = new DefaultStreamedContent(stream, "application/pdf");
            setStage(streamedContent);
        }
        return stage;

    }

    public List<Stage> getStages() {
        return competitionService.getCompetitionStages(competition);
    }

    public StreamedContent getSquad() {
        if (competition.getSquads() != null) {
            InputStream stream = new ByteArrayInputStream(competition.getSquads());
            StreamedContent streamedContent = new DefaultStreamedContent(stream, "application/pdf");
            setSquad(streamedContent);
        }
        return squad;
    }

    public List<Squad> getSquads() {
        return competitionService.getCompetitionSquads(competition);
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

    public void setSquad(StreamedContent squad) {
        this.squad = squad;
    }

    public void setStage(StreamedContent stage) {
        this.stage = stage;

    }
}

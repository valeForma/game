import com.dechit.cv.example.match.Partita;
import com.dechit.cv.example.ranking.ClassificaGenerale;
import com.dechit.cv.example.service.*;
import com.dechit.cv.example.user.Utente;


import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
       Utente utente = new Utente("Carmine","Carmine",'M', Date.from(Instant.now()),"FG","FUFDC","ASD","UMeghj123222345","asd");
        UserService userService = new UserServiceImpl();
        System.out.println(utente);
       userService.addPerson(utente);
        System.out.println("aggiunto");
        System.out.println("vedo se c'è");
        System.out.println(userService.getPersonById("Umeghj123222345"));
        System.out.println("trovato"+ userService.logIn("Umeghj123222345","asd").getNome());

        Partita partita = new Partita(34560,utente, Date.from(Instant.now()));
        MatchService matchService = new MatchServiceImp();

        matchService.addMatch(partita);

        ClassificaGenerale classificaGenerale=new ClassificaGenerale(utente,utente,partita,"badware");
        RankingService rankingService= new RankingServiceImpl();
        rankingService.addRanked(classificaGenerale);
        System.out.println("classifica");
        List list = rankingService.getAllRanking();
        list.forEach(e -> System.out.println(e.toString()));
    }
}

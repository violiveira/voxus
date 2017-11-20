package mb;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.FileReader;
import java.io.IOException;
import model.Usuario;

@ManagedBean
@SessionScoped
public class MBLogin implements Serializable {

    private Usuario usuario;
    private String googleCode;

    public void setUser(Usuario usuario) {
        usuario = this.usuario;
    }

    public String getGoogleCode() {
        return googleCode;
    }

    public String doLogin() throws FileNotFoundException, IOException{
        String authCode = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("loginForm:googleCodeContainer");
               
        // Set path to the Web application client_secret_*.json file you downloaded from the
        // Google API Console: https://console.developers.google.com/apis/credentials
        // You can also find your Web application client ID and client secret from the
        // console and specify them directly when you create the GoogleAuthorizationCodeTokenRequest
        // object.
        String CLIENT_SECRET_FILE = "/home/vinicius/NetBeansProjects/DashboardTasks/files/client_secret_263304735649-d6kse5c68fpkf1q9vcfc1s176miclqvm.apps.googleusercontent.com.json";
        //FileReader testFile = new FileReader(CLIENT_SECRET_FILE);
        // Exchange auth code for access token
        GoogleClientSecrets clientSecrets =
        GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), new FileReader(CLIENT_SECRET_FILE));
        GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(),
                      JacksonFactory.getDefaultInstance(),
                      "https://www.googleapis.com/oauth2/v4/token",
                      clientSecrets.getDetails().getClientId(),
                      clientSecrets.getDetails().getClientSecret(),
                      authCode, "http://localhost:34999/DashboardTasks").execute();

        String accessToken = tokenResponse.getAccessToken();

        // Use access token to call API
        GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
        Drive drive = new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName("Voxus Dashboard Auth").build();
        File file = drive.files().get("appfolder").execute();

        // Get profile info from ID token
        GoogleIdToken idToken = tokenResponse.parseIdToken();
        GoogleIdToken.Payload payload = idToken.getPayload();
        String userId = payload.getSubject();  // Use this value as a key to identify a user.
        String email = payload.getEmail();
        boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
        String name = (String) payload.get("name");
        String pictureUrl = (String) payload.get("picture");
        String locale = (String) payload.get("locale");
        String familyName = (String) payload.get("family_name");
        String givenName = (String) payload.get("given_name");

        System.out.println("Meu nome: "+name);       
        return null;
    }


    public String doLogout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", null);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        // Retornando loginPage. A regra de navegação levará até a página inicial.
        return "loginPage?faces-redirect=true";
    }
}

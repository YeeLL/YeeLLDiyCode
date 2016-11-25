package yeell.yeelldiycode.models;

import java.io.Serializable;

/**
 * Created by YeeLL on 11/25/16.
 */

public class TokenModel implements Serializable {
    public String access_token;
    public String token_type;
    public String expires_in;
    public String refresh_token;
    public int created_at;
}

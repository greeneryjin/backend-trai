//package trailProject.trail.security.token;
//
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import trailProject.trail.account.entity.Account;
//
//import java.util.Collection;
//
//public class JwtUsernamePasswordAuthenticationToken extends AbstractAuthenticationToken {
//
//    private String id;
//    private String name;
//
//    /**
//     * Creates a token with the supplied array of authorities.
//     *
//     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
//     *                    represented by this authentication object.
//     */
//    public JwtUsernamePasswordAuthenticationToken(String id, String name, Collection<? extends GrantedAuthority> authorities) {
//        super(authorities);
//        this.id = id;
//        this.name = name;
//    }
//
//    public JwtUsernamePasswordAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
//        super(authorities);
//    }
//
//    @Override
//    public Object getCredentials() {
//        return this.name;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return this.id;
//    }
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

/**
 *
 * @author kaine
 */
public class UserRole {

    public static enum role {
        USER {
            @Override
            public String toString() {
                return "USER";
            }
        },
        ADMIN {
            @Override
            public String toString() {
                return "ADMIN";
            }
        },
    }
}

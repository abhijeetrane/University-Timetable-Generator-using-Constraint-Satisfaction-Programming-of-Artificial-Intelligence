
package csp;


public interface Constraint {
	boolean constraintCheck(Selection assignment, String variable, Object value);

}
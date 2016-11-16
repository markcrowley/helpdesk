/**
 * 
 */
package utils;

/**
 * <p>
 * ExceptionMailer
 * </p>
 * 
 * @author Mark Crowley
 */
public class ExceptionMailer {

	public static void send(Throwable e) {
		System.out.println("Sending email containing exception " + e);
	}
}

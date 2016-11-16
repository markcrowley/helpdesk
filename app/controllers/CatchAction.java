/**
 * 
 */
package controllers;

import java.util.concurrent.CompletionStage;

import play.mvc.Action.Simple;
import play.mvc.Http.Context;
import play.mvc.Result;
import utils.ExceptionMailer;
import play.Logger;

/**
 * <p>
 * CatchAction
 * </p>
 * 
 * @author Mark Crowley
 */
public class CatchAction extends Simple {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CompletionStage<Result> call(Context ctx) {
		Logger.info("Calling action for {}", ctx);
		try {
			return delegate.call(ctx);
		} catch (Throwable e) {
			ExceptionMailer.send(e);
		}
		return null;
	}
}

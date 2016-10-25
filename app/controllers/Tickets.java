/**
 *
 */
package controllers;

import java.util.List;

import com.google.inject.Inject;

import models.Ticket;
import play.data.FormFactory;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.tickets.list;
import views.html.tickets.details;

/**
 * <p>
 * Tickets
 * </p>
 *
 * @author Mark Crowley
 */
public class Tickets extends Controller {

	@Inject
	FormFactory formFactory;

	public Result list() {
		List<Ticket> tickets = Ticket.findAll();
		return ok(list.render(tickets));
	}

	public Result newTicket() {
		return ok(details.render(formFactory.form(Ticket.class)));
	}

	public Result details(Long id) {
		return TODO;
	}

	public Result save() {
		Form<Ticket> boundForm = formFactory.form(Ticket.class).bindFromRequest();
		if (boundForm.hasErrors()) {
			flash("error", "Please correct errors above.");
			return badRequest(details.render(boundForm));
		} else {
			Ticket ticket = boundForm.get();
			ticket.save();
			flash("success", "Ticket created: " + ticket);
			return redirect(routes.Tickets.list());
		}
	}
}

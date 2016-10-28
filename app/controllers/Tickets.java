/**
 *
 */
package controllers;

import java.util.List;

import com.google.inject.Inject;

import models.Ticket;
import play.data.FormFactory;
import play.Logger;
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

	// @Inject
	// FormFactory formFactory;

	public Result list() {
		List<Ticket> tickets = Ticket.findAll();
		return ok(list.render(tickets));
	}

	public Result newTicket() {
		Form<Ticket> ticketForm = Form.form(Ticket.class)/*.fill(ticket);*/;
// formFactory.form(Ticket.class)

		return ok(details.render(ticketForm));
	}

	public Result details(Long id) {
		final Ticket ticket = Ticket.findById(id);
		if (null == ticket) {
			return notFound(String.format("Ticket #%d does not exist", id));
		}
		Form<Ticket> ticketForm = Form.form(Ticket.class).fill(ticket);
		ticketForm.fill(ticket);
		return ok(details.render(ticketForm));
	}

	public Result save() {
		Form<Ticket> boundForm = Form.form(Ticket.class).bindFromRequest();
		//
		//
		//
		//
		// Form<Ticket> boundForm = formFactory.form(Ticket.class).bindFromRequest();
		if (boundForm.hasErrors()) {
			flash("error", "Please correct errors below");
			return badRequest(details.render(boundForm));
		} else {
			Ticket ticket = boundForm.get();
			ticket.save();
			flash("success", "Ticket created: " + ticket);
			return redirect(routes.Tickets.list());
		}
	}

	public Result delete(Long id) {
		final Ticket ticket = Ticket.findById(id);
		if (null == ticket) {
			return notFound(String.format("Ticket #%d does not exists", id));
		}
		Ticket.remove(ticket);
		return redirect(routes.Tickets.list());
	}
}

/**
 * 
 */
package controllers;

import java.util.List;

import com.google.inject.Inject;

import models.Ticket;
import play.data.FormFactory;
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
	
	@Inject FormFactory formFactory;
	
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
		return TODO;
	}
}

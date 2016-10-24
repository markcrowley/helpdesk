/**
 * 
 */
package controllers;

import java.util.List;


import models.Ticket;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.tickets.list;
/**
 * <p>
 * Tickets
 * </p>
 * 
 * @author Mark Crowley
 */
public class Tickets extends Controller {
	
	public Result list() {
		List<Ticket> tickets = Ticket.findAll();
		return ok(list.render(tickets));
	}

	public Result newTicket() {
		return TODO;
	}

	public Result details(Long id) {
		return TODO;
	}

	public Result save() {
		return TODO;
	}
}

/**
 * 
 */
package models;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import play.data.validation.Constraints;

/**
 * <p>
 * Category
 * </p>
 * 
 * @author Mark Crowley
 */
public class Category {

	private static List<Category> categories = new LinkedList<Category>();
	static {
		categories.add(new Category(1L, "Mechanical and Electrical", Ticket.findByDescription("Desc 1")));
		categories.add(new Category(1L, "Building Fabric", Ticket.findByDescription("Desc 1")));
		categories.add(new Category(1L, "Cleaning", Ticket.findByDescription("Desc 1")));
	}
	public Long id;

	@Constraints.Required
	public String name;

	public List<Ticket> tickets;

	public Category() {
	}

	public Category(Long id, String name, Collection<Ticket> tickets) {
		this.id = id;
		this.name = name;
		this.tickets = new LinkedList<Ticket>(tickets);
		for (Ticket ticket : tickets) {
			ticket.categories.add(this);
		}
	}
}

/**
 *
 */
package models;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.Constraints;
/**
 * <p>
 * Ticket
 * </p>
 *
 * @author Mark Crowley
 *
 */
public class Ticket {

	private static List<Ticket> tickets;

	static {
		tickets = new ArrayList<Ticket>();
		tickets.add(new Ticket(1L, "Desc 1", "Req 1"));
		tickets.add(new Ticket(2L, "Desc 2", "Req 2"));
		tickets.add(new Ticket(3L, "Desc 3", "Req 3"));
		tickets.add(new Ticket(4L, "Desc 4", "Req 4"));
		tickets.add(new Ticket(5L, "Desc 5", "Req 5"));
		tickets.add(new Ticket(6L, "Desc 6", "Req 6"));
	}

    @Constraints.Required
	public Long id;

    @Constraints.Required
	public String description;

    @Constraints.Required
	public String requester;

	public Ticket() {

	}

	public Ticket(Long id, String description, String requester) {
		this.id = id;
		this.description = description;
		this.requester = requester;
	}

	public static List<Ticket> findAll() {
		return new ArrayList<Ticket>(tickets);
	}

	public static Ticket findById(Long id) {
		for (Ticket candidate : tickets) {
			if (candidate.id.equals(id)) {
				return candidate;
			}
		}
		return null;
	}

	public static List<Ticket> findByDescription(String term) {
		final List<Ticket> results = new ArrayList<Ticket>();
		for (Ticket candidate : tickets) {
			if (candidate.description.toLowerCase().contains(term.toLowerCase())) {
				results.add(candidate);
			}
		}
		return results;
	}

	public static boolean remove(Ticket ticket) {
		return tickets.remove(ticket);
	}

	public void save() {
		tickets.remove(findById(this.id));
		tickets.add(this);
	}

	public String toString() {
		return String.format("#%d - %s", id, description);
	}
}

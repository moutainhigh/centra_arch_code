package com.ifudata.ic.sso.ticket;

import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.ic.sso.util.SerializeUtil;
import org.jasig.cas.ticket.Ticket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TicketService{

	public void saveTicket(String key,Ticket ticket ,int secends){
		CommonService.getInstance().saveObj(key, ticket, secends);
	}

	public Ticket getTicket(String ticketId) {
		return (Ticket) CommonService.getInstance().getValue(ticketId);
	}

	public List<Ticket> getTickets() throws IOException, ClassNotFoundException {
		final Map<byte[], byte[]> values = CommonService.getInstance().getValues(CommonService.TICKET_REPOSITORY);
		List<Ticket> list = new ArrayList<Ticket>();
		if(values!=null&&!CollectionUtil.isEmpty(values.values())){
			for(byte[] obj:values.values()){
				list.add((Ticket)SerializeUtil.unserialize(obj));
			}
		}
		return list;
	}

	public void deleteTicket(String key) {
		CommonService.getInstance().removeObj(key);
	}
}

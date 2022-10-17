package fr.umfds.TP4_Mocks;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class Bibliothèque {
	private static Bibliothèque instance;
	private HashMap<String, NoticeBibliographique> notices=new HashMap<>();
	private LocalDate lastInventaire;
	private Bibliothèque() {lastInventaire=LocalDate.of(2021, 12, 06);} // on bloque l'accès au constructeur depuis l'extérieur

	public static Bibliothèque getInstance() {
		if (instance==null){
			instance=new Bibliothèque();
		}
		return instance;
	}

	public NoticeStatus  addNotice(NoticeBibliographique n) {
		NoticeStatus res;
		if (n==null) {
			res=NoticeStatus.notExisting;
		}else {
			NoticeBibliographique putresult= notices.put(n.getIsbn(), n);

			if (putresult==null) {
				res=NoticeStatus.newlyAdded;
			}else if (putresult.equals(n)) {
				res=NoticeStatus.nochange;
			}else {
				res=NoticeStatus.updated;
			}
		}
		return res;
	}

	public NoticeBibliographique getNoticeByIsbn(String isbn) {
		return notices.get(isbn);
	}

	public LocalDate getLastInventaire() {
		return lastInventaire;
	}

	public void inventaire() {
		this.lastInventaire = LocalDate.now(Clock.systemDefaultZone());
	}
	
	
}

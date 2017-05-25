package mapinfo;

import objects.*;
import java.util.*;

public class Maps {
	ArrayList<Monster> monster;
	ArrayList<Trap> trap;
	Carcenter carcenter;
	private Maps west; // shallow copy
	private Maps east; // ''
	private Maps north; // ''
	private Maps south; // ''
	Tooltip tooltip; // deep copy! or null
	Item item; // deep copy! or null
}

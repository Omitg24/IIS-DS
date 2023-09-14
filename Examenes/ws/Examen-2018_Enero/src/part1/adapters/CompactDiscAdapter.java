package part1.adapters;

import part1.model.CompactDisc;
import part1.view.Media;

public class CompactDiscAdapter implements Media {

	private CompactDisc compactDisc;
		
	public CompactDiscAdapter(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}

	@Override
	public String getCad1() {
		return this.compactDisc.getTitle();
	}

	@Override
	public String getCad2() {
		return this.compactDisc.getArtist();
	}	

}

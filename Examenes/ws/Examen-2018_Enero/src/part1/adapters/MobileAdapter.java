package part1.adapters;

import part1.model.Mobile;
import part1.view.Media;

public class MobileAdapter implements Media {

	private Mobile mobile;
	
	public MobileAdapter(Mobile mobile) {
		this.mobile = mobile;
	}

	@Override
	public String getCad1() {
		return this.mobile.getBrand();
	}

	@Override
	public String getCad2() {		
		return this.mobile.getModel();
	}

}

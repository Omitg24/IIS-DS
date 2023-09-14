package base;
import java.util.ArrayList;
import java.util.List;

public class Form {
	public void addField(Field campo) {
		fields.add(campo);
	}

	public void askData() {
		for (Field field : fields) {
			field.askData();
			System.out.println(field.getString());
		}
	}

	private List<Field> fields = new ArrayList<>();
}

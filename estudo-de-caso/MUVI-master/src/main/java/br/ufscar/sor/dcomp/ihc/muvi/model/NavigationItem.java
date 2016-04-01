package br.ufscar.sor.dcomp.ihc.muvi.model;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.object.Text;

/**
 *
 * @author gois
 */
public class NavigationItem {

	private Text text;
	private Image image;
	private Text toKnowMore;

	/*public NavigationItem(MuseologicalObject museologicalObject) {
	 if (museologicalObject instanceof Image) {
	 image = (Image) museologicalObject;
	 } else if (museologicalObject.getObjectType()) {
	 text = (Text) museologicalObject;
	 } else {
	 toKnowMore = (Text) museologicalObject;
	 }
	 }*/
	public NavigationItem(Scenario scenario) {
		for (MuseologicalObject object : scenario.getObjects()) {
			System.out.println(object.getId());
			boolean b = true;
			if (image == null/* && b*/) {
				if (object instanceof Text) {
					System.out.println("Text:" + ((Text) object).getText());
					if (text == null) {
						text = (Text) object;
					} else {
						text.setText(new StringBuilder()
								.append(text.getText())
								.append("\n")
								.append(((Text) object).getText())
								.substring(0));
					}
					b = object.getObjectType();
				} else if (object instanceof Image) {
					System.out.println("Url:" + ((Image) object).getUrlAddress());
					image = (Image) object;
				} else {
					throw new ClassCastException("Object " + object + "[id=" + object.getId() + "] need to be a Image or a Text");
				}
			} else {
				if (object instanceof Text) {
					if (toKnowMore == null) {
						toKnowMore = (Text) object;
					} else {
						toKnowMore.setText(new StringBuilder()
								.append(toKnowMore.getText())
								.append("\n")
								.append(((Text) object).getText())
								.substring(0));
					}
				} else {
					throw new ClassCastException("Object object[id=" + object.getId() + "] need to be a Text");
				}
			}
		}
	}

	public Text getText() {
		return text;
	}

	public Image getImage() {
		return image;
	}

	public Text getToKnowMore() {
		return toKnowMore;
	}

	public boolean belongs(MuseologicalObject candidate) {
		if (getName().equals(candidate.getName())) {
			return true;
		}

		return false;
	}

	public boolean set(MuseologicalObject candidate) {
		if (belongs(candidate)) {
			if (candidate instanceof Image) {
				image = (Image) candidate;

				return true;
			} else if (candidate instanceof Text) {
				if (candidate.getObjectType()) {
					text = (Text) candidate;
				} else {
					toKnowMore = (Text) candidate;
				}

				return true;
			}
		}

		return false;
	}

	public String getName() {
		if (text != null) {
			return text.getName();
		} else if (image != null) {
			return image.getName();
		} else if (toKnowMore != null) {
			return toKnowMore.getName();
		}
		return null;
	}

	public void print() {
		if (text != null) {
			System.out.println(text.getName());
		} else if (image != null) {
			System.out.println(image.getName());
		} else {
			System.out.println(toKnowMore.getName());
		}

		if (text != null) {
			System.out.println(text.getText());
		}
		if (image != null) {
			System.out.println(image.getUrlAddress());
		}
		if (toKnowMore != null) {
			System.out.println(toKnowMore.getText());
		}
	}

}

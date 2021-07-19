import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;

public class MySet<E extends Object> extends HashSet<E> implements PropertyChangeListener {
	private PropertyChangeSupport changeSupport;

	public MySet() {
		changeSupport = new PropertyChangeSupport(this);
		changeSupport.addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		System.out.println("chamou");
	}

	@Override
	public boolean add(E e) {
		//changeSupport.firePropertyChange("add", 0, 0);
		return super.add(e);
	}
	
	@Override
	public boolean remove(Object o) {
		boolean ret = super.remove(o);
		if(size()==1) {
			//remove a ultima e poe noutra lista
		}
		return ret;
	}
}
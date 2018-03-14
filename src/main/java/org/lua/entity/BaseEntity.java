/**
 * (c) 2009 Shanghai Schick Information Technologies Co., Ltd.
 * 
 * http://www.schickit.com
 */
package org.lua.entity;

import org.lua.web.BaseFormBean;

import javax.persistence.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * This is the superclass of all entites in the Model space.
 * It provides the following functionality to all Entities:
 * <ul>
 * <li>Defines an <code>id</code>-Attribute of type Integer. </li>
 * <li>Provides PropertyChangeListener-Support. Please note, that all
 *     <code>set<i>XYZ</i></code>-Methods are surrounded by
 *     propertyChangeEvent-fireing code by the aspect <code>BeanAspect</code>.
 *     To use this functionality, <b>you should never write to any field
 *     except in its own <code>set</code>-Method! Use this <code>set</code>-
 *     Method in all other cases!</b></li>
 * </ul>
 * <br>
 * 由于与Entity Annotation 名字冲突, 所以使用BaseEntity这个名字 
 * 
 * @author       $Author: JHuang $
 * @version      $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */
@MappedSuperclass
public abstract class BaseEntity<T extends BaseEntity> implements Comparable, Serializable {
	
	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/
	
    /**
	 * SerialID
	 */
	private static final long serialVersionUID = -8688310927224276504L;

	/*--------------------------------------------
	|    I N S T A N C E   V A R I A B L E S    |
	============================================*/
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	@Transient
    private transient List<PropertyChangeListener> propListeners;

    /*--------------------------------------------
	|  A C C E S S O R S / M O D I F I E R S    |
	============================================*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Adds a PropertyChangeListener to this entity. PropertyChangeListeners
     * get informed about a property change after the change has happened.
     * @param listener
     */
    @Transient
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if( propListeners == null ) {
            propListeners = new ArrayList<PropertyChangeListener>();
        }
        propListeners.add(listener);
    }

    /**
     * Removes a PropertyChangeListener
     * @param listener
     */
    @Transient
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if( propListeners == null ) {
            return;
        }
        propListeners.remove(listener);
    }
    
    /*-------------------------------------------
	|               M E T H O D S               |
	============================================*/
    
    /**
     * Fires a PropertyChangeEvent.
     *
     * @param propertyName
     * @param oldValue
     * @param newValue
     */
    @Transient
    protected void firePropertyChangeEvent(String propertyName, Object oldValue, Object newValue) {
        if( propListeners == null ) {
            return;
        }
        PropertyChangeEvent evt = new PropertyChangeEvent(this,propertyName,oldValue,newValue);
        for( PropertyChangeListener listener : propListeners ) {
            listener.propertyChange( evt );
        }
    }
    
    
    // -------------------- Super Class and Interface implement Functions --------------------------------

    /**
     * Returns true, if both objects are the same. For easy we assume, that
     * two objects are the same, if they both share the same not-null ID and
     * if they both have a null ID, we use reflection on all fields to
     * check for equalness.
     * TODO FIXME if entity no ID, how equals the two new entity?
     */
	@Override
    public boolean equals(Object obj) {

        //if same object return true
        if (this == obj) {
            return true;
        }

        //if null object return false
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BaseEntity)) {
            return false;
        }

        // Here we check if the classes are of the same object in
        // the database, even if they only have the same ancestor
        // in the class hierarchie (CompanyAdress might be equal
        // to Address)
        BaseEntity entity = (BaseEntity)obj;
        Class thisRootClass = findRootEntityClass(this);
        Class otherRootClass = findRootEntityClass(entity);
        if (!thisRootClass.getName().equals(otherRootClass.getName())) {
            return false;
        }

        // 1. any ID == null -> false
        // 2. ID's same -> true, else false
        return this.getId() == null ? false :
               this.getId().equals( entity.getId() );
    }

    /**
     * Returns a hashcode for this entity.
     */
    @Override
    public int hashCode() {
        if( id == null ) {
            return super.hashCode();
        }
        return id.hashCode();
    }

    /**
     * Compares this entity to some other entity.
     */
    public int compareTo(Object obj) {
        if( obj == null ) {
            return -1; // TODO: Ja? Oder 1?
        }
        if( !obj.getClass().getName().equals(getClass().getName()) ) {
            return obj.getClass().getName().hashCode() - getClass().getName().hashCode();
        }
        T o = (T)obj;
        if (equals(o)){
            return 0;
        }
        if( o.getId() == null ) {
            if( getId() != null ) {
                return 1;
            }
        }
        if( o.getId() != null ) {
            if( getId() == null ) {
                return -1;
            }
        }
        if( o.getId() == null && id == null ) {
            return o.hashCode() - this.hashCode();
        }
        return o.getId().intValue()-this.getId().intValue();
    }

    /**
     * Returns the first class directly under EntityBase in the class hierarchie
     * of the given object.
     * <p>
     * We compare the classes by name. The reason is, that, maybe when loaded in
     * different class loaderd
     *
     * @param entity
     */
    @Transient
    public static Class findRootEntityClass(BaseEntity entity) {
        Class clazz = entity.getClass();
        if( clazz.equals(BaseEntity.class) ) {
            return clazz;
        }
        while( !clazz.getSuperclass().equals(BaseEntity.class) ) {
            clazz = clazz.getSuperclass();
        }
        return clazz;
    }
    
    /**
     * Gets whether this instance is not saved in the database.
     */
    @Transient
    public boolean isNew() {
    	return id == null;
    }
    
    /**
     * Returns whether this instance is saved in the database.
     */
    @Transient
    public boolean isPersist() {
    	return id != null;
    }
    
    public BaseFormBean toTableBean(BaseEntity baseEntity){
    	return null;
    }
    
}

package com.mylist;
/**
 * Class provides the wrapper of the objects could be placed to the list
 * @author Andrey
 *
 */
public class CustomWrapper {
private byte type;
private Number number;
private String string;

public CustomWrapper(Number number) {
	this.number = number;
	this.type=1;
}

public CustomWrapper(String string) {
	this.string = string;
	this.type=0;
}

@Override
	public String toString() {
		return type==1?this.number.toString():this.string.toString();
	}

}

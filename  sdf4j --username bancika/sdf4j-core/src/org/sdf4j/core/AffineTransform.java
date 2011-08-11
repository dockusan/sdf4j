//package org.sdf4j.core;
//
//public class AffineTransform {
//
//	double m00;
//	double m10;
//	double m01;
//	double m11;
//	double m02;
//	double m12;
//
//	public AffineTransform(double m00, double m10, double m01, double m11, double m02, double m12) {
//		super();
//		this.m00 = m00;
//		this.m10 = m10;
//		this.m01 = m01;
//		this.m11 = m11;
//		this.m02 = m02;
//		this.m12 = m12;
//	}
//
//	public double getM00() {
//		return m00;
//	}
//
//	public double getM10() {
//		return m10;
//	}
//
//	public double getM01() {
//		return m01;
//	}
//
//	public double getM11() {
//		return m11;
//	}
//
//	public double getM02() {
//		return m02;
//	}
//
//	public double getM12() {
//		return m12;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		long temp;
//		temp = Double.doubleToLongBits(m00);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = Double.doubleToLongBits(m01);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = Double.doubleToLongBits(m02);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = Double.doubleToLongBits(m10);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = Double.doubleToLongBits(m11);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		temp = Double.doubleToLongBits(m12);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		AffineTransform other = (AffineTransform) obj;
//		if (Double.doubleToLongBits(m00) != Double.doubleToLongBits(other.m00))
//			return false;
//		if (Double.doubleToLongBits(m01) != Double.doubleToLongBits(other.m01))
//			return false;
//		if (Double.doubleToLongBits(m02) != Double.doubleToLongBits(other.m02))
//			return false;
//		if (Double.doubleToLongBits(m10) != Double.doubleToLongBits(other.m10))
//			return false;
//		if (Double.doubleToLongBits(m11) != Double.doubleToLongBits(other.m11))
//			return false;
//		if (Double.doubleToLongBits(m12) != Double.doubleToLongBits(other.m12))
//			return false;
//		return true;
//	}
//}

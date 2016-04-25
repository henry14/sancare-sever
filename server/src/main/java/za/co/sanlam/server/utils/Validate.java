package za.co.sanlam.server.utils;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import za.co.sanlam.model.exception.ValidationException;

public class Validate {
	
	public static void isNotNull(Object object, String name)
			throws ValidationException {
		if (object == null)
			throw new ValidationException(name + " can not be blank");
	}

	public static void isNotNull2(Object object, String error)
			throws ValidationException {
		if (object == null)
			throw new ValidationException(error);
	}

	public static void isNull(Object object, String name)
			throws ValidationException {
		if (object != null)
			throw new ValidationException(name + " is expected to be blank");
	}

	public static void isNotBlank(String str, String name)
			throws ValidationException {
		if (StringUtils.isBlank(str))
			throw new ValidationException(name + " can not be blank");
	}

	public static void isNotFutureDate(Date date, String name)
			throws ValidationException {
		isNotNull(date, name);

		if (date.after(new Date()))
			throw new ValidationException(name + " can not be a future date");
	}

	/*public static void dateOrderCorrect(Date b4Date, Date afterDate,
			String b4DateName, String afterDateName) throws ValidationException {
		if (afterDate.before(b4Date))
			throw new ValidationException(afterDateName + " ("
					+ MyDateUtil.dateFormat_dd_MMM_yy.format(afterDate)
					+ ") can not be before " + b4DateName + " ("
					+ MyDateUtil.dateFormat_dd_MMM_yy.format(b4Date) + ")");
	}*/

	public static void isGreaterThan(Integer value, Integer limit, String name)
			throws ValidationException {
		isNotNull(value, name);

		if (value < limit)
			throw new ValidationException(name + " must be greater than "
					+ limit);
	}

	public static void isGreaterThan(Double value, Double limit, String name)
			throws ValidationException {
		isNotNull(value, name);

		if (value < limit)
			throw new ValidationException(name + " must be greater than "
					+ limit);
	}

	public static void isNotGreaterThan(Integer value, Integer limit,
			String name) throws ValidationException {
		isNotNull(value, name);

		if (value > limit)
			throw new ValidationException(name + " must not be greater than "
					+ limit);
	}

	public static void isNotGreaterThan(Double value, Double limit, String name)
			throws ValidationException {
		isNotNull(value, name);

		if (value > limit)
			throw new ValidationException(name + " must not be greater than "
					+ limit);
	}

	public static void isNotLessThanZero(Integer value, String name)
			throws ValidationException {
		if (value < 0)
			throw new ValidationException(name + " can not be less than 0");
	}

	public static void isNotLessThanZero(Double value, String name)
			throws ValidationException {
		if (value < 0.0)
			throw new ValidationException(name + " can not be less than 0");
	}

	public static void isNotLessOrEqualToZero(Integer value, String name)
			throws ValidationException {
		if (value <= 0)
			throw new ValidationException(name
					+ " can not be less or equal to 0");
	}

	public static void isNotLessOrEqualToZero(Double value, String name)
			throws ValidationException {
		if (value <= 0.0)
			throw new ValidationException(name
					+ " can not be less or equal to 0");
	}

	public static void isInRange(Double value, Double start, Double end,
			String name) throws ValidationException {
		if (value < start || value > end)
			throw new ValidationException(name + " can't be less than " + start
					+ " or greater than " + end);
	}

	public static void isInRange(Integer value, Integer start, Integer end,
			String name) throws ValidationException {
		if (value < start || value > end)
			throw new ValidationException(name + " can't be less than " + start
					+ " or greater than " + end);
	}

}

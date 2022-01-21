
package helper;

import javax.servlet.http.HttpServletRequest;


public class GetVariable {

    HttpServletRequest request;

    public GetVariable(HttpServletRequest request) {
        this.request = request;
    }

    public String getString(String key, String label, int minLength, int maxLength, String defaultValue) {
        String value = (String) this.request.getParameter(key);
        if (value == null || value.trim().isEmpty()) {
            if (defaultValue == null) {
                request.setAttribute(key + "Error", label + " is required");
                return null;
            }
            return defaultValue;
        }

        if (value.trim().length() > maxLength) {
            request.setAttribute(key + "Error", label + " is less than or equal " + maxLength + " character(s)");
            return null;
        }

        if (value.trim().length() < minLength) {
            request.setAttribute(key + "Error", label + " is greater than or equal " + minLength + " character(s)");
            return null;
        }

        return value.trim();
    }

    public Float getFloat(String key, String label, float minValue, float maxValue, Float defaultValue) {
        String value = (String) this.request.getParameter(key);
        Float number;
        if (value == null || value.isEmpty()) {
            if (defaultValue == null) {
                request.setAttribute(key + "Error", label + " is required");
                return null;
            }
            return defaultValue;
        }

        try {
            number = Float.parseFloat(value);
        } catch (Exception e) {
            request.setAttribute(key + "Error", label + " must be a number ");
            return null;
        }

        if (number >= maxValue) {
            request.setAttribute(key + "Error", label + " must less than " + maxValue);
            return null;
        }
        if (number < minValue) {
            request.setAttribute(key + "Error", label + " must large than or equal " + minValue);
            return null;
        }

        return number;
    }

    public Integer getInt(String key, String label, int minValue, int maxValue,
            Integer defaultValue) {

        String valueInt = (String) this.request.getParameter(key);
        Integer numValue;

        if (valueInt == null || valueInt.isEmpty()) {
            if (defaultValue == null) {
                request.setAttribute(key + "Error", label + " is required");
                return null;
            }
            return defaultValue;
        }
        try {
            numValue = Integer.parseInt(valueInt);
        } catch (Exception e) {
            request.setAttribute(key + "Error", label + " is an Integer");
            return null;
        }
        if (numValue < minValue) {
            request.setAttribute(key + "Error", label + " is less than or equal" + minValue);
            return null;
        }
        if (numValue > maxValue) {
            request.setAttribute(key + "Error", label + "  is greater than or equal" + maxValue);
            return null;
        }

        return numValue;
    }

}

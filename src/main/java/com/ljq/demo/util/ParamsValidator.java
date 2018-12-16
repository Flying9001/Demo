package com.ljq.demo.util;

import com.ljq.demo.annotation.ParamsCheck;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 参数校验类
 * @Author: junqiang.lu
 * @Date: 2018/12/16
 */
public class ParamsValidator {

    private ParamsValidator(){}


    /**
     * 参数校验方法
     * 当被校验对象的参数符合要求时,返回 null
     * 当被校验对象不符合某一项校验要求时,返回对应的错误信息
     *
     * @param arg 参数对象
     * @return
     * @throws Exception
     */
    public static String validateParams(Object arg) throws Exception {
        String result = null;
        // 获取参数的所有成员变量
        Field[] field = arg.getClass().getDeclaredFields();
        for (int j = 0; j < field.length; j++) {
            // 获取方法参数对象 field 上的 ParamsCheck 注解
            ParamsCheck check = field[j].getAnnotation(ParamsCheck.class);
            if (check != null) {
                result = validateField(check, field[j], arg);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;

    }

    /**
     * 参数字段校验
     *
     * @param paramsCheck 参数校验注解
     * @param field 字段
     * @param arg 参数对象
     * @return
     * @throws Exception
     */
    private static String validateField(ParamsCheck paramsCheck, Field field, Object arg) throws Exception{
        field.setAccessible(true);

        /**
         * 非空校验
         */
        if (paramsCheck.notNull()) {
            if (field.get(arg) == null || "".equals(String.valueOf(field.get(arg)))) {
                return "[" + field.getName() + "]" + paramsCheck.desc() + "参数不能为 null";
            }
        }

        /**
         * 最大值校验
         */
        if (paramsCheck.max() != -1) {
            int param = Double.valueOf(String.valueOf(field.get(arg))).intValue();
            if (param > paramsCheck.max()) {
                return "[" + field.getName() + "]" + paramsCheck.desc() + "参数最大值不可超过" + paramsCheck.max();
            }
        }

        /**
         * 最小值校验
         */
        if (paramsCheck.min() != -1) {
            int param = Double.valueOf(String.valueOf(field.get(arg))).intValue();
            if (param < paramsCheck.min()) {
                return "[" + field.getName() + "]" + paramsCheck.desc() + "参数最小值不可小于" + paramsCheck.min();
            }
        }

        /**
         * 字符串最大长度校验
         */
        if (paramsCheck.strMaxLength() != -1) {
            String param = String.valueOf(field.get(arg));
            int paramLength = param.length();
            if (paramLength > paramsCheck.strMaxLength()) {
                return "[" + field.getName() + "]" + paramsCheck.desc() + "参数最大长度不可超过" + paramsCheck.strMaxLength();
            }
        }

        /**
         * 字符串最小长度校验
         */
        if (paramsCheck.strMinLength() != -1) {
            String param = String.valueOf(field.get(arg));
            int paramLength = param.length();
            if (paramLength < paramsCheck.strMinLength()) {
                return "[" + field.getName() + "]" + paramsCheck.desc() + "参数最小长度不可小于" + paramsCheck.strMinLength();
            }
        }

        /**
         * 手机号检验
         */
        if (paramsCheck.isMobile()) {
            String param = String.valueOf(field.get(arg));
            String regExp = "^((13[0-9])|145|147|(15[^4])|166|(17[^2])|(17[^4])|(17[^9])|(18[0-9])|(19[8-9]))\\d{8}$";
            Pattern p = Pattern.compile(regExp);
            Matcher m = p.matcher(param);
            if (!m.matches()) {
                return "[" + field.getName() + "]" + paramsCheck.desc() + "参数不符合手机号格式要求";
            }
        }

        /**
         * 邮箱校验
         */
        if (paramsCheck.isEmail()) {
            String param = String.valueOf(field.get(arg));
            String regExp = "^((([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])" +
                    "+(\\.([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])" +
                    "+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]" +
                    "|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|" +
                    "(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*" +
                    "(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-z]|\\d|" +
                    "[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])" +
                    "([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|" +
                    "[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])" +
                    "|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|" +
                    "[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))$";
            Pattern p = Pattern.compile(regExp);
            Matcher m = p.matcher(param.toLowerCase());
            if (!m.matches()) {
                return "[" + field.getName() + "]" + paramsCheck.desc() + "参数不符合邮箱格式要求";
            }
        }

        /**
         * 数字字母校验
         */
        if (paramsCheck.isAlphanumericStr()) {
            String param = String.valueOf(field.get(arg));
            String regex = "[a-z]*[A-Z]*\\d*";
            if(param.replaceAll(regex,"").length() > 0) {
                return "[" + field.getName() + "]" + paramsCheck.desc() + "参数不符合数字字母要求,参数值包含特殊符号";
            }
        }

        /**
         * 纯数字字符串校验
         */
        if (paramsCheck.isNumericStr()) {
            String param = String.valueOf(field.get(arg));
            for (int i = 0; i < param.length(); i++) {
                if (!Character.isDigit(param.charAt(i))) {
                    return "[" + field.getName() + "]" + paramsCheck.desc() + "参数不符合纯数字要求,参数值包含非数字字符";
                }
            }
        }


        return null;
    }




}

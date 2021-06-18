package top.meethigher.demo05.service.impl;

import top.meethigher.demo05.service.AccountService;

import java.util.*;

/**
 * AccountServiceImpl2
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/27
 */
public class AccountServiceImpl2 implements AccountService {
    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties props;

    public AccountServiceImpl2(Set<String> mySet, Map<String, String> myMap) {
        this.mySet = mySet;
        this.myMap = myMap;
    }

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }


    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public void saveAccount() {
        System.out.println("myStrs=" + Arrays.toString(myStrs) +
                "\nmyList=" + myList +
                "\nmySet=" + mySet +
                "\nmyMap=" + myMap +
                "\nprops=" + props);
    }
}

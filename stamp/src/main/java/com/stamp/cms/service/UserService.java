package com.stamp.cms.service;

import java.util.List;

import com.stamp.cms.model.User;
 
public interface UserService {
    /**
     * ����� ��� ��ȸ
     * @return
     */
    public List<User> selectUserList();
     
    /**
     * ����� ��ȸ
     * @param uid
     * @return
     */
    public User selectUser(Long uid);
     
    /**
     * ����� ���
     * @param user
     */
    public void insertUser(User user);
     
    /**
     * ����� ���� ����
     * @param user
     */
    public void updateUser(User user);
     
    /**
     * ����� ����
     * @param uid
     */
    public void deleteUser(Long uid);
}
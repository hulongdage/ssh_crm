package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {
	//��½����
	User	getUserByCodePassword(User u);
	//ע���û�
	void saveUser(User u);
}

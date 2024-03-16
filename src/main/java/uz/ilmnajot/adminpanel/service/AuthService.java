package uz.ilmnajot.adminpanel.service;

import uz.ilmnajot.adminpanel.model.common.ApiResponse;
import uz.ilmnajot.adminpanel.model.dto.LoginDto;

public interface AuthService {
    ApiResponse login(LoginDto dto);

}

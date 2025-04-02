

/*
 * Created on 2024-11-08 ( Time 00:22:29 )
 * Generator tool : Telosys Tools Generator ( version 3.3.0 )
 * Copyright 2017 Savoir Faire Linux. All Rights Reserved.
 */

package com.wdyapplications.pharmapp.business.fact;

import com.wdyapplications.pharmapp.dao.entity.Users;
import com.wdyapplications.pharmapp.dao.repository.UsersRepository;
import com.wdyapplications.pharmapp.utils.ExceptionUtils;
import com.wdyapplications.pharmapp.utils.FunctionalError;
import com.wdyapplications.pharmapp.utils.Validate;
import com.wdyapplications.pharmapp.utils.contract.IBasicBusiness;
import com.wdyapplications.pharmapp.utils.contract.Request;
import com.wdyapplications.pharmapp.utils.contract.Response;
import com.wdyapplications.pharmapp.utils.dto.UsersDto;
import com.wdyapplications.pharmapp.utils.enums.FunctionalityEnum;
import com.wdyapplications.pharmapp.utils.enums.GlobaleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;


/**
 * BUSINESS factory
 *
 * @author Geo
 */

@Component
public class BusinessFactory<DTO> {

	@Autowired
	private UsersRepository userRepository;
    @Autowired
    private FunctionalError functionalError;
    @Autowired
    private ExceptionUtils  exceptionUtils;

    /**
     * create entity by using dto as object.
     *
     * @param request
     * @return response
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public Response<DTO> create(IBasicBusiness<Request<DTO>, Response<DTO>> iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Response<DTO> response = new Response<DTO>();
        try {
            checkUserAccess(request, functionalityEnum, locale);
            response = iBasicBusiness.create(request, locale);
        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                 throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
            }
        }
        return response;
    }

    /**
     * update entity by using dto as object.
     *
     * @param request
     * @return response
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public Response<DTO> update(IBasicBusiness<Request<DTO>, Response<DTO>> iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Response<DTO> response = new Response<DTO>();
        try {
            checkUserAccess(request, functionalityEnum, locale);
            response = iBasicBusiness.update(request, locale);
        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                 throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
            }
        }
        return response;
    }

    /**
     * delete entity by using dto as object.
     *
     * @param request
     * @return response
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public Response<DTO> delete(IBasicBusiness<Request<DTO>, Response<DTO>> iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Response<DTO> response = new Response<DTO>();
        try {
            checkUserAccess(request, functionalityEnum, locale);
            response = iBasicBusiness.delete(request, locale);
        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                 throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
            }
        }
        return response;
    }

    /**
     * delete entity by using dto as object.
     *
     * @param request
     * @return response
     */
    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    public Response<DTO> getByCriteria(IBasicBusiness<Request<DTO>, Response<DTO>> iBasicBusiness, Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Response<DTO> response = new Response<DTO>();
        try {
            checkUserAccess(request, functionalityEnum, locale);
            response = iBasicBusiness.getByCriteria(request, locale);
        } catch (PermissionDeniedDataAccessException e) {
            exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (DataAccessResourceFailureException e) {
            exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
        } catch (DataAccessException e) {
            exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
        } catch (RuntimeException e) {
            exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
        } catch (Exception e) {
            exceptionUtils.EXCEPTION(response, locale, e);
        } finally {
            if (response.isHasError() && response.getStatus() != null) {
                 throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
            }
        }
        return response;
    }

    private void checkUserAccess(Request<DTO> request, FunctionalityEnum functionalityEnum, Locale locale) {
        Map<String, Object> fieldsToVerifyUser = new HashMap<String, Object>();
        fieldsToVerifyUser.put("user", request.getUser());
        if (!Validate.RequiredValue(fieldsToVerifyUser).isGood()) {
            throw new RuntimeException(functionalError.FIELD_EMPTY(Validate.getValidate().getField(), locale).getMessage());
        }

        Response<UsersDto> userResponse = isGranted(request.getUser(), functionalityEnum.getValue(), locale);
        if (userResponse.isHasError()) {
            throw new RuntimeException(userResponse.getStatus().getMessage());
        }
    }

	/**
	 * 
	 * @param userId
	 * @param functionalityCode
	 * @param locale
	 * @return
	 */
    private Response<UsersDto> isGranted(Integer userId, String functionalityCode, Locale locale){
		// System.out.println("----begin get isGranted-----");

		Response<UsersDto> response = new Response<UsersDto>();

		try {
			Users currentUser = userRepository.findOne(userId, false);
			if (currentUser == null) {
				response.setStatus(functionalError.DATA_NOT_EXIST("Utilisateur -> " + userId, locale));
				response.setHasError(true);
				return response;
			}

			if (Objects.equals(currentUser.getStatusId(), GlobaleEnum.RESTRICTED)) {
				response.setStatus(functionalError.REQUEST_FAIL("L'utilisateur "+currentUser.getUsername()+" est verouille(e)" , locale));
				response.setHasError(true);
				return response;
 			}
    		
			//if (Utilities.isFalse(currentUser.getIsSuperAdmin()) && Utilities.areNotEquals(FunctionalityEnum.DEFAULT.getValue(), functionalityCode)) {
//				if (Utilities.notBlank(functionalityCode)) {
//					Functionality functionality = roleFunctionalityRepository.isGranted(currentUser.getRole().getId(), functionalityCode ,false);
//					if (functionality == null) {
//						response.setHasError(true);
//						response.setStatus(functionalError.USER_NOT_GRANTED("", locale));
//						return response;
//					}
//				}
			//}

			response.setHasError(false);
			// System.out.println("----end get isGranted-----");

		} catch (PermissionDeniedDataAccessException e) {
			exceptionUtils.PERMISSION_DENIED_DATA_ACCESS_EXCEPTION(response, locale, e);
		} catch (DataAccessResourceFailureException e) {
			exceptionUtils.DATA_ACCESS_RESOURCE_FAILURE_EXCEPTION(response, locale, e);
		} catch (DataAccessException e) {
			exceptionUtils.DATA_ACCESS_EXCEPTION(response, locale, e);
		} catch (RuntimeException e) {
			exceptionUtils.RUNTIME_EXCEPTION(response, locale, e);
		} catch (Exception e) {
			exceptionUtils.EXCEPTION(response, locale, e);
		} finally {
			if (response.isHasError() && response.getStatus() != null) {
				// System.out.println(String.format("Erreur| code: {} -  message: {}", response.getStatus().getCode(), response.getStatus().getMessage()));
				throw new RuntimeException(response.getStatus().getCode() + ";" + response.getStatus().getMessage());
			}
		}

		return response;
	}

  }

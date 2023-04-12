import http from '../http-common.jsx'

class RegistrationService {
  addMedicalUser(data){
    return http.post('/medicalUsers',data);
  }
}

export default new RegistrationService();
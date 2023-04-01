import http from '../http-common'

class LoginService {
  login(data) {
    return http.get(`/patientLogin/${data}`)
  }
  fetch(data){
    return http.get(`/patientUsers/${data}`)
  }
}

export default new LoginService()

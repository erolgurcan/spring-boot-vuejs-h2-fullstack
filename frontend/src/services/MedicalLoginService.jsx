import http from '../http-common'

class MedicalLoginService {
  login(data) {
    return http.get(`/medicalLogin/${data}`)
  }
}

export default new MedicalLoginService()

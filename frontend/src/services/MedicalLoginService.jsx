import http from '../http-common'

class MedicalLoginService {
  login(data) {
    return http.get(`/medicalLogin/${data}`)
  }
  fetchMedicalInfoByMedicalID(data) {
    return http.get(`/medicalUsers/${data}`)
  }

}

export default new MedicalLoginService()

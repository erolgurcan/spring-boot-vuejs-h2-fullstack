<template>
  <div>
    <nav class="mt-4" aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Medical Dashboard</li>
      </ol>
    </nav>
    <div class="card mt-5 shadow-fade">
      <div class="card-body mt-2">
        <h3 class="text text-primary"><strong>Medical Dashboard</strong></h3>
      </div>
    </div>

    <div class="custom-card mt-5  mx-5  myblue shadow-fade">
      <div class="card-body">
        <h3 class="text-white"><strong> Hello {{ medicalUserModel.userFullName }}</strong></h3>
        <h5 class="text-white"><strong>Medical Registration: </strong> {{ medicalUserModel.medicalID }} <strong> | Role:</strong> {{medicalUserModel.role}}</h5>
      </div>
    </div>


    <div class="row mt-5 justify-content-center align-items-center">
      <div class="col-lg-5">
        <div class="card shadow-fade py-4">
          
          <RouterLink class="nav-link active" aria-current="page" to="/TreatmentsManagement">
        <img src="../assets/images/treatment.png" class="img-thumbnail-custom shadow-fade">
          </RouterLink>
    


          <p>
          <h2 class="text-primary text-center">Treatments</h2>
          </p>
        </div>
      </div>
      <div class="col-lg-5">
        <div class="card shadow-fade py-4">
          <RouterLink class="nav-link active" aria-current="page" to="/PatientsManagement">
        <img src="../assets/images/users.png" class="img-thumbnail-custom shadow-fade">
      </RouterLink>
          <p>
          <h2 class="text-primary text-center">Patients</h2>
          </p>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import MedicalLoginService from '../services/MedicalLoginService'
import patientUserModel from '../models/patientUserModel'
import medicalUserModel from '../models/medicalUserModel'
import treatmentModel from '../models/treatmentModel'
import TreatmentsManagement from './TreatmentsManagement.vue'
export default {
  data() {
    return {
      patientUserModel,
      medicalUserModel,
      treatmentModel,
    }
  },
  methods: {
    fetchMedicalUser() {
      let MedicaluserId = localStorage.getItem('userId')
      console.log(MedicaluserId);
      

      MedicalLoginService.fetchMedicalInfoByMedicalID(MedicaluserId)
        .then((response) => {
          this.medicalUserModel = new medicalUserModel(response.data);
          console.log(response.data);
        })
       
        .catch((error) => {
          console.log(error)
        })
    }//,

 
  },
  mounted() {
    this.fetchMedicalUser();
  }
}
</script>



<style scoped></style>

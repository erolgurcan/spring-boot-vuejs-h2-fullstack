<template>
    <div>
        <div>
            <nav class="mt-4" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <router-link to="/medicalUserDashboard">
                            Home
                        </router-link></li>
                    <li class="breadcrumb-item active" aria-current="page">Patients</li>
                </ol>
            </nav>
        </div>
        <div class="custom-card mt-5 myPink shadow-fade">
            <div class="card-body mt-2">
                <h3 class="text text-white"><strong>Patients</strong></h3>
            </div>
        </div>
    </div>

    <div class="col-lg-1 mt-5 ms-auto justify-content-end">
        <button type="button" class="btn btn-outline-primary shadow-fade" data-toggle="modal"
            data-target=".bd-example-modal-lg">Add</button>
        <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
            aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">New Patient</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="fullName" class="col-form-label text-lg-end">Full Name:</label>
                                </div>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="recipient-name" v-model="patData.fullName">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label text-lg-end">Birth Date:</label>
                                </div>
                                <div class="col-sm-3 ">
                                    <input type="date" class="form-control" id="birthdate" v-model="patData.birthDate">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                <label class="my-1 col-form-label text-lg-end" for="inlineFormCustomSelectPref"> Gender:</label>
                                </div>
                                <div class="col-sm-4">
                                <select class="custom-select" id="selectGender" @change ="handleGenderSelect" v-model="patData.gender">
                                    <option selected>Choose...</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                    <option value="Not informed">Prefer not inform</option>
                                </select>
                            </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label text-lg-end">Email:</label>
                                </div>
                                <div class="col-sm-7">
                                    <input type="email" class="form-control" id="recipient-name" v-model="patData.email">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label text-lg-end">Password:</label>
                                </div>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="recipient-name" v-model="patData.password">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">Phone:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="recipient-name" v-model="patData.phone">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">Health Card Number:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="recipient-name" v-model="patData.healthCard">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">Address:</label>
                                </div>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="recipient-name" v-model="patData.address">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">City:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="recipient-name" v-model="patData.city">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">Province:</label>
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="recipient-name" v-model="patData.province">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">ZIP
                                        Code:</label>
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="recipient-name" v-model="patData.zipCode">
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary" @click="savePatient" data-dismiss="modal">Save</button>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div class="mt-3">
        <table class="table table-hover shadow-fade">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Full Name</th>
                    <th scope="col">Birth Date</th>
                    <th scope="col">Health Card</th>
                    <th scope="col">Email</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Address</th>
                    <th scope="col">City</th>
                    <th scope="col">Province</th>
                    <th scope="col">ZIP Code</th>
                </tr>
            </thead>
            <tbody>
                
                <tr v-if="patients.length" v-for="(pat, index) in patients" :key="index">
                    <th scope="row">{{ pat.patientId }}</th>
                    <td > {{pat.fullName }} </td>
                    <td>{{pat.birthDate}}</td>
                    <td>{{pat.healthCard}}</td>
                    <td>{{pat.email}}</td>
                    <td>{{pat.phone}}</td>
                    <td>{{pat.address}}</td>
                    <td>{{pat.city}}</td>
                    <td>{{pat.province}}</td>
                    <td>{{pat.zipCode}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
    
<script>
import { RouterLink, RouterView } from 'vue-router';
import PatientInfoService from '../services/PatientInfoService';

export default{
    name:"patientsList",
    
    data(){
        const patData= {
        fullName: '',
        birthDate: '',
        gender: '',
        email: '',
        phone: '',
        healthCard: '',
        address: '',
        city: '',
        province: '',
        zipCode: '',
        password: '',
        };
        
        return{
            patients:[],
            treatmendId: 1,
            patData            
        }

    },

    methods: {


        savePatient(event){
            event.preventDefault();
            PatientInfoService.addPatient(this.treatmendId,this.patData)
                .then(response=>{
                    console.log(response.data);
                })
                .catch(error=>{
                    console.log(error);
                })


        },

        retrievePatientInfo(){
            PatientInfoService.getPatients()
                .then(response=>{
                    this.patients = response.data;
                })
                .catch(error=>{
                    console.log(error);
                })
        }

    },

    mounted(){
        this.retrievePatientInfo();
        this.treatmendId = localStorage.getItem('treatId');
    }
}
</script>
    
<style></style>
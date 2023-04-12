<template>
     <div>
    <nav class="mt-4" aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <router-link to="/medicalUserDashboard">
            Home
          </router-link></li>
        <li class="breadcrumb-item active" aria-current="page">Treatments</li>
      </ol>
    </nav>
     </div>
     <div class="custom-card mt-5 myRed shadow-fade">
      <div class="card-body mt-2">
        <h3 class="text text-white"><strong>Treatments</strong></h3>
      </div>
    </div>

    <div class="col-lg-1 mt-5 ms-auto justify-content-end">
        <button type="button" class="btn btn-outline-primary2 shadow-fade" data-toggle="modal"
            data-target=".bd-example-modal-lg">Add</button>
        <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
            aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">New Treatment</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="fullName" class="col-form-label text-lg-end">Treatment title:</label>
                                </div>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="recipient-name" v-model="treatData.title">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label text-lg-end">Treatment Process:</label>
                                </div>
                                <div class="col-sm-7 ">
                                    <textarea class="form-control" id="birthdate" rows="3" placeholder="Describe the process here..." v-model="treatData.treatProcess"></textarea>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                <label class="my-1 col-form-label text-lg-end" for="inlineFormCustomSelectPref"> Materials:</label>
                                </div>
                                <div class="col-sm-7">
                                  <input type="text" class="form-control" id="recipient-name" v-model="treatData.materials">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label text-lg-end">Tips:</label>
                                </div>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="recipient-name" v-model="treatData.tips">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary2" @click="saveTreatment" data-dismiss="modal">Save</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="mt-5">
        <table class="table table-hover shadow-fade">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Treatment</th>
      <th scope="col">Treating Process</th>
      <th scope="col">Materials</th>
      <th scope="col">Tips</th>
    </tr>
  </thead>
  <tbody>
    <tr :id="index+1" v-if="treatments.length" v-for="(treat ,index) in treatments" :key="index" @click="addTreatmentInfo(index)">
      <th scope="row">{{treat.id}}</th>
      <td>{{treat.title}}</td>
      <td>{{treat.treatProcess}}</td>
      <td>{{treat.materials}}</td>
      <td>{{treat.tips}}</td>
    </tr>
  </tbody>
</table>
    </div>

</template>

<script>
import { RouterLink } from 'vue-router';
import TreatmentInfoService from '../services/TreatmentInfoService';

export default{
    name:"treatmentList",
    
    data(){
      const treatData= {
        title: '',
        treatProcess: '',
        materials: '',
        tips: '',
        };
        
        return{
            treatments:[],
            medicalId:1,
            treatData,
            
        }

    },

    methods: {
      addTreatmentInfo(ind){
        localStorage.setItem('treatId',this.treatments[ind].id);
        console.log(localStorage);
        this.$router.push({ name: 'patientsManagement' })
      },

      saveTreatment(event){
        event.preventDefault();
        TreatmentInfoService.addTreatment(this.medicalId,this.treatData)
                .then(response=>{
                    console.log(response.data);
                    location.reload();
                })
                .catch(error=>{
                    console.log(error);
                })
      },

        retrieveTreatmentInfo(){
            TreatmentInfoService.getTreatments()
                .then(response=>{
                    this.treatments = response.data;
                    
                })
                .catch(error=>{
                    console.log(error);
                })
        }

    },

    mounted(){

        this.retrieveTreatmentInfo();
        this.medicalId = localStorage.getItem('id');
    }
  }
</script>

<style scoped>

</style>
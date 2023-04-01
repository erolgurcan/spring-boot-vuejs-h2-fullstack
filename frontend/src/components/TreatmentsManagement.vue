<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
     <div>
    <nav class="mt-4" aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Treatments</li>
      </ol>
    </nav>
     </div>
     <div class="custom-card mt-5 myRed shadow-fade">
      <div class="card-body mt-2">
        <h3 class="text text-white"><strong>Treatments</strong></h3>
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
    <tr>
      <th scope="row">1</th>
      <td>Cut on hand</td>
      <td>Apply Gauze on the injury</td>
      <td>Gauze</td>
      <td>Apply Gauze on the injury</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Cut on arm</td>
      <td>Cover the wound with a bandage</td>
      <td>bandage</td>
      <td>Wash the wound first and stop the bleeding</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Injury on leg</td>
      <td>Apply the ointment over the wound and cover it with some bandage</td>
      <td>Antibiotic Ointment, bandage</td>
      <td>Wash the wound first and stop the bleeding</td>
    </tr>
    <tr>
      <th scope="row">4</th>
      <td>Minor burn on index finger</td>
      <td>Apply lotion and bandage the burn, take a paiin reliever</td>
      <td>Lotion, bandage, pain reliever	</td>
      <td>Cool the burn under cool running water first, don't break blisters</td>
    </tr>
    <tr>
      <th scope="row">5</th>
      <td>Strain in the leg</td>
      <td>Hold ice on the area for 20 minutes, wrap an elastic bandage or splint around the strain, put a pillow under the injured leg to keep it raised</td>
      <td>Elastic bandage, pillow, ice</td>
      <td>Rest the limb to give it a chance to heal</td>
    </tr>
   
  </tbody>
</table>
    </div>

     
     
     
     


</template>



<style scoped></style>
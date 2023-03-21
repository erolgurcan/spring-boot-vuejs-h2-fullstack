<script setup></script>

<template>
  <div>
    <nav class="mt-4" aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Patient Dashboard</li>
      </ol>
    </nav>

    <div class="card mt-4 shadow-fade">
      <div class="card-body">
        <h3 class="text text-primary"><strong>Patient Dashboard</strong></h3>
      </div>
    </div>

    <div class="row mt-5 ">
      <div class="col-lg-6">
        <div class="card shadow-fade" style="min-height:450px">
          <div class="card-body" style="text-align: left">
            <h3 class="card-title text-center"><strong>Elon Musk</strong></h3>
            <hr />
            <h6 class="card-subtitle mb-2 text-muted">User ID: 1111111</h6>
            <hr />
            <p class="card-text"><strong>Age :</strong> 40</p>
            <p class="card-text"><strong>Gender :</strong> Male</p>
            <p class="card-text"><strong>Phone :</strong> 1 111 11 11</p>
            <p class="card-text"><strong>Email :</strong> elonmusk@gmail.com</p>
            <p class="cart text">
              <strong>Address :</strong> 1111 xxx Street, XXX XXX Vancouver, Canada
            </p>
          </div>
        </div>
      </div>

      <div class="col-lg-6 shadow-fade">
        <div class="card">
          <h4 class="card-title text-center mt-2"><strong>Assigned Doctor</strong>: Tim Cook</h4>
          <hr />
          <h5>email: tim.cook@gmail phone: 2 222 22 22</h5>
          <hr />
          <ul class="list-group" style="text-align: left">
            <li class="list-group-item active"><strong>Upcoming Treatments</strong></li>
            <li class="list-group-item"><strong>Applied For: </strong> Cut on hand</li>
            <li class="list-group-item">
              <strong>How to threat: </strong> Apply Gauze on the injury area
            </li>
            <li class="list-group-item"><strong>Equipments: </strong>Gauze</li>
            <li class="list-group-item"><strong>Tips:</strong> Be careful!</li>
          </ul>
          <p>
            <button
              class="btn btn-secondary mt-2"
              type="button"
              data-toggle="collapse"
              data-target=".multi-collapse"
              aria-expanded="false"
              aria-controls="multiCollapseExample1 multiCollapseExample2"
            >
              Click to see details
            </button>
          </p>
        </div>
      </div>
    </div>

    <div class="row mt-4">
      <div class="col">
        <div class="collapse multi-collapse" id="multiCollapseExample1">
          <div class="card card-body">
            <h4><strong>Step 1</strong></h4>
            <img class = "m-auto" src="../assets/images/injury-1.jpg" style="max-width: 150px;">
          </div>
        </div>
      </div>
      <div class="col">
        <div class="collapse multi-collapse" id="multiCollapseExample2">
          <div class="card card-body">
            <h4><strong>Step 2</strong></h4>
            <img  class = "m-auto" src="../assets/images/injury-2.jpg" style="max-width: 150px;">
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>

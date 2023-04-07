<template>
    <div>
        <div>
            <nav class="mt-4" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
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
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label text-lg-end">Birth Date:</label>
                                </div>
                                <div class="col-sm-3 ">
                                    <input type="date" class="form-control" id="birthdate">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                <label class="my-1 col-form-label text-lg-end" for="inlineFormCustomSelectPref"> Gender:</label>
                                </div>
                                <div class="col-sm-4">
                                <select class="custom-select" id="inlineFormCustomSelect">
                                    <option selected>Choose...</option>
                                    <option value="1">Male</option>
                                    <option value="2">Female</option>
                                    <option value="3">Prefer not inform</option>
                                </select>
                            </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label text-lg-end">Email:</label>
                                </div>
                                <div class="col-sm-7">
                                    <input type="email" class="form-control" id="recipient-name">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">Phone:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">Health Card Number:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">Address:</label>
                                </div>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">City:</label>
                                </div>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">Province:</label>
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-3">
                                    <label for="recipient-name" class="col-form-label">ZIP
                                        Code:</label>
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control" id="recipient-name">
                                </div>
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Send message</button>
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
                <tr>
                    <th scope="row">1</th>
                    <td>Bill Clinton</td>
                    <td>19-06-1998</td>
                    <td>1234</td>
                    <td>bill@clinton.com</td>
                    <td>123456789</td>
                    <td>abc, 123 st</td>
                    <td>Vancouver</td>
                    <td>BC</td>
                    <td>V1V1V2</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Barak Obama</td>
                    <td>12-03-1997</td>
                    <td>1234</td>
                    <td>barak@obama.com</td>
                    <td>113456789</td>
                    <td>abc, 124 st</td>
                    <td>Vancouver</td>
                    <td>BC</td>
                    <td>V1V1V2</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Hillary Clinton</td>
                    <td>10-04-1996</td>
                    <td>1234</td>
                    <td>hillary@clinton.com</td>
                    <td>123456780</td>
                    <td>abc, 123 st</td>
                    <td>Vancouver</td>
                    <td>BC</td>
                    <td>V1V1V2</td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>Joe Biden</td>
                    <td>13-05-1992</td>
                    <td>1234</td>
                    <td>joe@biden.com</td>
                    <td>223456789</td>
                    <td>abc, 125 st</td>
                    <td>Vancouver</td>
                    <td>BC</td>
                    <td>V1V1V2</td>
                </tr>

            </tbody>
        </table>
    </div>
</template>
    
<script>
import { RouterLink, RouterView } from 'vue-router'
</script>
    
<style></style>
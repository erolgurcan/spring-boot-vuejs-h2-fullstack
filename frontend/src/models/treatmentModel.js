export default class treatmentModel {

    id; title; treatProcess; materials; tips;

    constructor(data) {
        this.id = data.id;
        this.title = data.title;
        this.treatProcess = data.treatProcess;
        this.materials = data.materials;
        this.tips = data.tips;
    }

}
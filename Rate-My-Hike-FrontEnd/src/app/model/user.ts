export class User{
    id:number;
    username: string;
    password: string;
    emailAddress:string;
  
    constructor(){
        this.id = 0;
        this.username="";
        this.password="";
        this.emailAddress="";
    }
  }
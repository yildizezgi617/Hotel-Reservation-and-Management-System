import { Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { SssComponent } from './components/sss/sss.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ContactComponent } from './components/contact/contact.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { LoginComponent } from './components/auth/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { authGuard } from './guards/auth.guard';
import { HotelManagmentComponent } from './components/hotels/hotel-managment/hotel-managment.component';
import { CreateHotelComponent } from './components/hotels/create-hotel/create-hotel.component';
import { MyHotelListComponent } from './components/hotels/my-hotel-list/my-hotel-list.component';
import { HotelAddressComponent } from './components/hotels/hotel-address/hotel-address.component';
import { HotelImageComponent } from './components/hotels/hotel-images/hotel-images.component';
import { RoomComponent } from './components/room/room.component';
import { HotelDetailsComponent } from './components/hotels/hotel-details/hotel-details.component';
import { AvailableRoomsComponent } from './components/room/available-rooms/available-rooms.component';
import path from 'path';
import { CreatereReservationComponent } from './components/reservation/createre-reservation/createre-reservation.component';
import { ConfirmReservationComponent } from './components/reservation/confirm-reservation/confirm-reservation.component';
import { ReservationDetailsComponent } from './components/reservation/reservation-details/reservation-details.component';
import { SupportComponent } from './components/support/support.component';
import { CreateSupportComponent } from './components/support/create-support/create-support.component';
import { SupportListComponent } from './components/support/support-list/support-list.component';
import { MyReservationListComponent } from './components/reservation/my-reservation-list/my-reservation-list.component';
import { RoomUpdateComponent } from './components/room/room-update/room-update.component';
import { HotelReservationListComponent } from './components/hotels/hotel-reservation-list/hotel-reservation-list.component';
import { CreateUserAddressComponent } from './components/profile/create-user-address/create-user-address.component';
import { AddressUpdateComponent } from './components/profile/address-update/address-update.component';
import { HotelUpdateComponent } from './components/hotels/hotel-update/hotel-update.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { UpdateReservationComponent } from './components/reservation/update-reservation/update-reservation.component';
import { HotelFeedbacksComponent } from './components/hotels/hotel-feedbacks/hotel-feedbacks.component';
import { FeedbackResponseComponent } from './components/feedback/feedback-response/feedback-response.component';
import { FeedbackListForUsersComponent } from './components/feedback/feedback-list-for-users/feedback-list-for-users.component';


export const routes: Routes = [
    {
        path: '',
        component: HomePageComponent,

    },
    {
        path: 'sss',
        component: SssComponent
    },
    {
        path: 'aboutus',
        component: AboutUsComponent
    },
    {
        path: 'contact',
        component: ContactComponent
    },
    {
        path: 'register',
        component: RegisterComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'profile',
        component: ProfileComponent,
        canActivate: [authGuard]
    },
    {
        path: 'availableroomslist',
        component: AvailableRoomsComponent,
    },
    {
        path: 'createreservation',
        component: CreatereReservationComponent,
        canActivate: [authGuard],
    },
    {
        path: 'createuseraddress',
        component: CreateUserAddressComponent,
        canActivate: [authGuard],
    },
    {
        path: 'confirmreservation',
        component: ConfirmReservationComponent,
        canActivate: [authGuard],
    },
    {
        path: 'reservationdetails',
        component: ReservationDetailsComponent,
        canActivate: [authGuard],
    },
    {
        path: 'myreservationlist',
        component: MyReservationListComponent,
        canActivate: [authGuard],
    },
    {
        path: 'roomupdate',
        component: RoomUpdateComponent,
        canActivate: [authGuard],
    },
    {
        path: 'feedbacklist',
        component: HotelFeedbacksComponent,
        canActivate: [authGuard],
    },
    {
        path: 'addfeedback',
        component: FeedbackComponent,
        canActivate: [authGuard],
    },
    {
        path: 'addfeedbackresponse',
        component: FeedbackResponseComponent,
        canActivate: [authGuard],
    },
    {
        path: 'hotelreservationlist',
        component: HotelReservationListComponent,
        canActivate: [authGuard],
    },
    {
        path: 'updatereservation',
        component: UpdateReservationComponent,
        canActivate: [authGuard],
    },
    {
        path: 'feedbackforusers',
        component: FeedbackListForUsersComponent,
    },
    {
        path: 'updatehotel',
        component: HotelUpdateComponent,
        canActivate: [authGuard],
    },
    {
        path: 'addressupdate',
        component: AddressUpdateComponent,
        canActivate: [authGuard],
    },

    {
        path: 'hotelmanagment',
        component: HotelManagmentComponent,
        canActivate: [authGuard],
        children: [
            {
                path: 'createhotel',
                component: CreateHotelComponent,
            },
            {
                path: 'myhotellist',
                component: MyHotelListComponent,
            },
            {
                path: 'addhoteladdress',
                component: HotelAddressComponent
            },
            {
                path: 'addhotelimages',
                component: HotelImageComponent
            },
            {
                path: 'addroom',
                component: RoomComponent
            },
            {
                path: 'hoteldetails',
                component: HotelDetailsComponent
            }
        ]
    },
    {
        path: 'support',
        component: SupportComponent,
        canActivate: [authGuard],
        children: [
            {
                path: 'createsupport',
                component: CreateSupportComponent,
            },
            {
                path: 'supportlist',
                component: SupportListComponent,
            }
        ]
    },
];

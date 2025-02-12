package com.fanap.hotel.controller;

import com.fanap.hotel.dto.BaseResponse;
import com.fanap.hotel.dto.room.*;
import com.fanap.hotel.service.RoomService;
import com.fanap.hotel.util.constants.Constants;
import com.fanap.hotel.util.constants.ResponseCodePool;
import com.fanap.hotel.util.constants.Routes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Routes.ROOM_ROUTE)
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping(Routes.ROOM_ID_PARAM_KEY)
    public ResponseEntity<BaseResponse<RoomInfoDTO>> getRoom(@PathVariable(value = Constants.ID) Long roomId){
        return ResponseEntity.ok(BaseResponse.success(roomService.getRoomInfo(roomId)));
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<RoomInfoDTO>>> getAllRooms(){
        return ResponseEntity.ok(BaseResponse.success(roomService.getAllRoomsInfo()));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<RoomInfoDTO>> createRoom(@RequestBody CreateRoomRequestDTO createRoomRequestDTO){
        return ResponseEntity.ok(BaseResponse.success(roomService.createRoom(createRoomRequestDTO)));
    }

    @PutMapping (Routes.ROOM_ID_PARAM_KEY)
    ResponseEntity<BaseResponse<RoomInfoDTO>> updateRoom(@PathVariable(value = Constants.ID) Long roomId, @RequestBody CreateRoomRequestDTO createRoomRequestDTO){
        return ResponseEntity.ok(BaseResponse.success(roomService.updateRoom(roomId, createRoomRequestDTO)));
    }

    @DeleteMapping (Routes.ROOM_ID_PARAM_KEY)
    ResponseEntity<BaseResponse<String>> deleteRoom(@PathVariable(value = Constants.ID) Long roomId){
        roomService.deleteRoom(roomId);
        return ResponseEntity.ok(BaseResponse.success(ResponseCodePool.ROOM_DELETED.getMessage()));
    }
}
